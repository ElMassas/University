import sys
#import TI_Trabalho.trabalho.probabilities as probs

# Building and initializing the data structures
dictionnary = {chr(i): i for i in range(127)} #representing ASCII table with no extra ordinary symbols
compressed = []

##################################################
#   Arguments: received data
#   Returns: null
# 
# 
#   Compresses the data using the LZW compression
#   algorithm, compresses to binary
#
###################################################

def compress(uncompressed_data):
    previous = "" 
    size = len(dictionnary)

    for current in uncompressed_data:        
        if previous + current in dictionnary:
            previous = previous + current
        else:
            compressed.append(dictionnary[previous])
            dictionnary[previous + current] = size + 1
            size += 1
            previous = current

    compressed.append(dictionnary[previous])# loop doesn't iterate through the whole data so this needed to be added 


##################################################
#   Arguments: received data, compressed data
#   Returns: null
# 
# 
#   Writes the received data and the compressed 
#   data in to a file
#
###################################################
#needs refresh to accomodate for last element
def write_file(data, compressed):
    with open("registered_values.txt", "w") as rf:
        rf.write("size of data: " + str(len(data)) + "\n -> Inserted data:\n" + str(data) + "\nCompressed:\n")
        for element in compressed:
            rf.write("| %s " % element)


## Entropy and probabilities ##

#def probabilities(data, len(input_data))
#    entropy = probs.entropy(data, len(input_data))


if __name__ == "__main__":
    input_data = sys.stdin.read()
    compress(input_data)
    write_file(input_data, compressed)
    for index in range(len(compressed)):
        print(compressed[index])



## perhaps send the information about the hamming code to the decompressor? NO, it would be corrupted 