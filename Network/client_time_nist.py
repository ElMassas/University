import socket

ipaddr = socket.gethostbyname('time.nist.gov')
clientsocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)


clientsocket.connect((ipaddr, 13))
result = clientsocket.recv(128)
print(result.decode())