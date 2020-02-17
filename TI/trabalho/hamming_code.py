def n_redundant_bits(data_size):
    for index in range(dat_size):
        if(2**index >= data_size + i + 1):
            return i

def position_redundant_bits(data, data_size, redundants):
    bitpos1, bitpos2 = 0, 1 # to calculate position of redundant bits corrosponding to positions to the power of 2
    result = ''

    for index in range(1, data_size + redundants + 1):
        if(i == 2 ** bitpos1):
            result += '0'
            bitpos1 += 1
        else:
            result += data[-1 * bitpos2]
            bitpos2 += 1

    return result[::-1]

def error_detect(data, data_size, redundants):
    res = 0

    for  in range(redundants):
        temp = 0
        #call function to calculate the parity bits
        for index in range(1, data_size + 1):


