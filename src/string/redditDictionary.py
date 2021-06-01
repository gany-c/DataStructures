# import requests
# import mysql.connector
# import pandas as pd


# At Reddit, a big part of our job is to let our users find the best stuff in Reddit. To do this, we use a Search Engine, which lets us find Posts that match a query given by a user. For example, if you search for "meme", we want to be able to show all of the posts that use the word meme in their title of explanatory text. For this interview, we want you to build the simplest system that can do that job: Given a query, find all of the "documents" that contain the word or words in that query. We're going to start really simple, and will just match single words.

# We really are looking for the simplest approach to start with, so don't overthink the first pass code
# Having said that, we want to be able to add more sentences to the index, without re-indexing the sentences we've already added

# The sample sentences are:

def preprocess(sentences):
    # key = word, value = list of sentences
    output = {}
    for sentence in sentences:
         words = sentence.split()
         for word in words:
            if word in output.keys():
                sent_set = output[word]
                sent_set.add(sentence)
                output[word] = sent_set
            else:
                sent_set = {sentence, }
                output[word] = sent_set
    return output             
    
    
def findSentencesMapBased(query, sentence_map):
    if query in sentence_map.keys():
        return sentence_map[query]
    else:
        return set()

def findSentences(query, sentences):
    
    output = []
    for sentence in sentences:
        # creates a list of words
        words = sentence.split()
        # linear lookup inside a list
        if query in words:          
            output.append(sentence)
    return output        

sentences = [
    'the quick brown fox',
    'the slow brown cow',
    'to be or not to be that is the question',
]

# The queries are:
queries = [
    'the',
    'cow',
    'to',
]


print(findSentences('cow', sentences))
print(findSentences('ow', sentences))
print(findSentences('the', sentences))
print(findSentences('he', sentences))
print("========================================")
sentences_map = preprocess(sentences)

print(findSentencesMapBased('cow', sentences_map))
print(findSentencesMapBased('ow', sentences_map))
print(findSentencesMapBased('the', sentences_map))
print(findSentencesMapBased('he', sentences_map))
