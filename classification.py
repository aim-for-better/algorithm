
import os
import numpy as np
np.random.seed(1337)

from keras.preprocessing.text import Tokenizer

from keras.preprocessing.sequence import pad_sequences
from keras.utils.np_utils import to_categorical

from keras.layers import Dense,Input,Flatten

from keras.layers import Conv1D ,MaxPooling1D,Embedding
from keras.models import Model

from keras.optimizers import *
from keras.models import Sequential
from keras.layers import Merge
import sys

BASE_DIR="/media/zzy/F/cnn_test_data/"
GLOVE_DIR=BASE_DIR+"glove.6B/"
TEXT_DATA_DIR=BASE_DIR+"newsgroups/"
MAX_SEQUENCE_LENGTH=1000
MAX_NB_WORDS=20000

EMBEDDING_DIM=50

VALIDATION_SPLIT=0.4

print("Indexing word vectors")

embedding_index={}

f=open(os.path.join(GLOVE_DIR,'glove.6B.50d.txt'))

count=0
for line in f:
    # if count<5:
    #     print line
    # count=count+1
    values=line.split()
    word=values[0]
    # print len(word)
    codef=np.asarray(values[1:],dtype='float32')
    embedding_index[word]=codef

f.close()

print ('Found %s word vectors. ' % len(embedding_index))


print("Processing text dataset")

texts=[]   #  list of text samples the
labels_index={}  # dictionary mapping label name to numeric id
labels=[] # list of label ids



"""
the  name is a dirctionar that is the category 's name

total is 20 names

"""
for name in sorted(os.listdir(TEXT_DATA_DIR)):

    path=os.path.join(TEXT_DATA_DIR,name)

    # the path is the path in which is the news named digit
    if os.path.isdir(path):

        label_id=len(labels_index)
        labels_index[name]=label_id
        for fname in sorted(os.listdir(path)):
            if fname.isdigit():

                fpath=os.path.join(path,fname)
                # python 2.x
                if sys.version_info<(3,):
                    f=open(fpath)
                else:
                    f=open(fpath,encoding="utf-8")
                # f is the file that the context is new
                texts.append(f.read())

                f.close()
                labels.append(label_id)


print("Found %s texts" % len(texts))

## the above build the input x and the output  labels
# print("the details of texts is: ",texts[0])

tokenizer =Tokenizer(nb_words=MAX_NB_WORDS)
tokenizer.fit_on_texts(texts)
sequences=tokenizer.texts_to_sequences(texts)

word_index=tokenizer.word_index



print("Found %s unique tokens ." % len(word_index))




# the data is the tensor data as input after handle with raw text
data=pad_sequences(sequences,maxlen=MAX_SEQUENCE_LENGTH)





labels=to_categorical(np.asarray(labels))


print("Shape of data tensor :",data.shape)
print("Shape of label tensor :",labels.shape)

# split the data into a training set and a validation set
indices=np.arange(data.shape[0])
print indices


np.random.shuffle(indices)
# shuffle the data
data=data[indices]
labels=labels[indices]
nb_validation_samples=int(VALIDATION_SPLIT*data.shape[0])

# create the train of x,y and the validation x,y
x_train=data[:-nb_validation_samples]
y_train=labels[:-nb_validation_samples]
x_val=data[-nb_validation_samples:]
y_val=labels[-nb_validation_samples:]

#prepare embedding matrix
print("Preparing embedding matrix")

nb_words=min(MAX_NB_WORDS,len(word_index))

# why is nb_words +1 ,rather nb_words
embedding_matrix=np.zeros((nb_words+1,EMBEDDING_DIM))

for word,i in word_index.items():
    if i>MAX_NB_WORDS:
        continue
    embedding_vector=embedding_index.get(word)
    if embedding_vector is not None:
        embedding_matrix[i]=embedding_vector


embedding_layer=Embedding(nb_words+1,EMBEDDING_DIM,
                          input_length=MAX_SEQUENCE_LENGTH,
                          weights=[embedding_matrix],
                          trainable=True)

print("Training model")


# left model
model_left=Sequential()

model_left.add(embedding_layer)
model_left.add(Conv1D(128,5,activation="tanh"))
model_left.add(MaxPooling1D(5))
model_left.add(Conv1D(128,5,activation="tanh"))
model_left.add(MaxPooling1D(5))
model_left.add(Conv1D(128,5,activation="tanh"))
model_left.add(MaxPooling1D(35))
model_left.add(Flatten())

#right model

model_right=Sequential()
model_right.add(embedding_layer)
model_right.add(Conv1D(128,4,activation="tanh"))
model_right.add(MaxPooling1D(4))
model_right.add(Conv1D(128,4,activation="tanh"))
model_right.add(MaxPooling1D(4))
model_right.add(Conv1D(128,4,activation="tanh"))
model_right.add(MaxPooling1D(28))
model_right.add(Flatten())

#third model
model_3=Sequential()
model_3.add(embedding_layer)
model_3.add(Conv1D(128,6,activation="tanh"))
model_3.add(MaxPooling1D(3))
model_3.add(Conv1D(128,6,activation="tanh"))
model_3.add(MaxPooling1D(3))
model_3.add(Conv1D(128,6,activation="tanh"))
model_3.add(MaxPooling1D(30))
model_3.add(Flatten())

merged=Merge([model_left,model_right,model_3],mode="concat")

model=Sequential()
model.add(merged)
model.add(Dense(128,activation="tanh"))
model.add(Dense(len(labels_index),activation="softmax"))

model.compile(loss="categorical_crossentropy",
              optimizer="Adadelta",
              metrics=["accuracy"])

model.fit(x_train,y_train,nb_epoch=3)

score=model.evaluate(x_train,y_train,verbose=0)

print("train score: ",score[0])
print("train accuracy: ",score[1])

score=model.evaluate(x_val,y_val,verbose=0)
print("Test score: ",score[0])
print("Test accuracy: ",score[1])
