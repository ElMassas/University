import sys
import functools

#https://tech.peoplefund.co.kr/2018/11/28/programming-paradigm-and-python-eng.html
#https://blog.newrelic.com/engineering/python-programming-styles/
#https://opensource.com/article/19/10/python-programming-paradigms

def mdc_functional(a, b):
    #someone else do this dumb sheite

def mdc_procedural(a, b):
    while(true):
        if a == b:
            print('mmc ->' + str(a))
        elif b > a:
            b = b -a
        else:
            a = a - b
            
    
def mdc_oo(a, b):
    class gcd(a, b):
        def __init__(self, a ,b):
            self.a = a
            self.b = b
        def calculate(self):
            while(true):
                if a == b:
                    print('mmc ->' + str(a))
                elif b > a:
                    b = b -a
                else:
                    a = a - b
    
    do = gcd(a, b)
    do.calculate()
    
def mdc_imperative(a, b):
    if a == b:
        print('mmc ->' + str(a))
    elif b > a:
        mdc(a, b - a)
    else:
        mdc( a - b, b)
        
        
if __name__ == "__main__":
    a = sys.argv[1]
    b = sys.argv[2]

    
    mdc_imperative(int(a), int(b))
    mdc_oo(int(a), int(b))
    mdc_procedural(int(a), int(b))
    mdc_functional(int(a), int(b))
