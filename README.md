# smallProgram
Plenty of small programs

# threadTest
1. Producing 100 threads.
2. com.demo.ThreadApplication.main create 10 producer threads(ThreadFactory), not including in 100 threads.
3. Each ThreadFactory produces 10 threads
4. When thread count was in (20, 40, 60, 80, 100), wait a while.
5. When 100 threads were created, each thread could end.
6. Producer thread could end anytime, but the Main program should end until all 100 threads are done.

# scrollDemo
1. RWD, desktop:window width >= 640px, mobile: 0~639px
2. Initial Image position and size to the painting on second monitor.
3. Resize the image when scrolling, and change the focus on center.
4. Scrolling up will resume the Image.