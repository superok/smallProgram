# smallProgram
Plenty of small program

# threadTest
1. Producing 100 threads.
2. com.demo.ThreadApplication.main create 10 producer threads(ThreadFactory), not inclding in 100 threads.
3. Each ThreadFactory produces 10 threads
4. When thead count was in (20, 40, 60, 80, 100), wait a while.
5. When 100 threads were created, each thread could end.
6. Producer thread could end anytime, but the Main program should end until all 100 threads are done.
