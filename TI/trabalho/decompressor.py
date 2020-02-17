import sys, re
#import hamming_code as hamming
#import probabilities as probs

dictionnary = {chr(i): i for i in range(127)} #representing ASCII table with no extra ordinary symbols
decompressed = []

def organizeData(data):
    data = re.split('\n| \0', data)
    result = []

    for index in range(len(data) - 1):
        result.append(int(data[index]))
    return result

##################################################
#   Arguments: received data(array of bits)
#   Returns: null
# 
# 
#   Decompresses the data using the LZW compression
#   algorithm, decompresses to string
#
###################################################

def decompress(compressed_data):
    result = ''
    previous = compressed_data[0]
    print(type(previous))
    s = ''
    c = ''
    size = len(dictionnary)

    for index in range(len(compressed_data)):
        current = str(chr(compressed_data[index]))
        if current not in dictionnary:
            s = str(chr(previous))
            s += c
        else:
            s = current
            print('result is: ' + result)
        result += s
        c = s[0]
        dictionnary[compressed_data[index]] = previous + compressed_data[index]
        previous = compressed_data[index]

    return result


'''def decompress(compressed_data):
    result = ''
    size = len(dictionnary)

    for index in range(0, len(compressed_data)):
        if compressed_data[index] in dictionnary:
            result += str(dictionnary[compressed_data[index]])
        if compressed_data[index] > size:
            
        else:
            result += chr(compressed_data[index]) 

    if len(result) < 8:
        while len(result) <= 8:
            result += '-'        

    return result'''


#def write_file(data, compressed):
#    with open("registered_values.txt", "w") as rf:
#        rf.write(str(len(data) + "\n -> Inserted data: " + str(data) + "\nCompressed:\n"))
#        for element in compressed:
#            rf.write("| %s " % element)
#

#def hamming_correction(data):


if __name__ == "__main__":
    input_data = sys.stdin.read()#comes in as a string
    print('no format Input: \n' + input_data + '\n')
    input_data = organizeData(input_data)
    print(input_data)
    data = decompress(input_data)
    print('print data: ' + data)

