This is a simple client server program
which runs a server which is always listening.
Once a client initiates a connection a new socket
is instantiated and a separate thread is invoked 
to handle the communication. The service provided is
simply capitalizing the message sent to the server and
returning it back to the user. The server allows 
five messages for each client and can handle several
clients at once by making use of threads.