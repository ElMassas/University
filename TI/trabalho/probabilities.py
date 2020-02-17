import math, os.path

def file_validity(input_file):
    if os.path.exists(input_file) == True and os.path.getsize(input_file) > 0:

        print('\n -> IP file is valid\n')

        selected_file = open(input_file, 'r')

        selected_file.seek(0)

        data = selected_file.read()

        return data.split()
    
    else:
        print('\n | File {} does not exist at the given directory \n | Please check and try again \n'.format(input_file))
        
        sys.exit()


def entropy (p, q):
	
	ent = -( p * math.log(p , 2) + q * math.log(q , 2))

    return ent

def entropy_conditioned(ent, p0, p1, q0, q1):

	entro1 = -( p0 * math.log(p0 , 2) + q0 * math.log(q0 , 2) + -( p0 * math.log(p0 , 2) + q1 * math.log(q1 , 2)))
	
	entro2 = -( p1 * math.log(p0 , 2) + q0 * math.log(q0 , 2) + -( p1 * math.log(p0 , 2) + q1 * math.log(q1 , 2)))

	entro = entro1 + entro2

	entro_cond = entro - ent

    return entro_cond


def entropy_compressed():
