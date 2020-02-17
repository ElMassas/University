import sys

def mdc(a, b):

    if a == b:
        print('mmc ->' + str(a))
    elif b > a:
        mdc(a, b - a)
    else:
        mdc( a - b, b)
        
if __name__ == "__main__":
    a = sys.argv[1]
    b = sys.argv[2]

    
    mdc(int(a), int(b))
