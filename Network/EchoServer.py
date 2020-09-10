import socket

HOST = '127.0.0.1'  # Standard loopback interface address (localhost)
PORT = 65432        # Port to listen on (non-privileged ports are > 1023)

'''
AF_INET -> Internet address family for IPv4
SOCK_SREAM -> Socket type for TCP
'''
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s: #socket.socket() creates a socket object that supports context manager type
    s.bind((HOST, PORT))#Since we're using IPv4 the bind func expects a 2-tuple(host, port)
    s.listen()#has a backlog parameter that specifies the number of unaccepted connections that the system will allow before refusing new connections
    conn, addr = s.accept() #blocks and waits for an incomming connection. Creates socket object, different from the listening one
    with conn:
        print('Connected by', addr)
        while True:
            data = conn.recv(1024)
            if not data:
                break
            conn.sendall(data)