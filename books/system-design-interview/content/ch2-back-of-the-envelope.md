# CHAPTER 2: BACK-OF-THE-ENVELOPE ESTIMATION
One of the aspects of the system design is the capacity calculation. For example, calculate the storage volume for Twitter. Or design distributed queue with the maximum latency of 10ms, etc.
There are three important concepts that every developer should know

## Power of Two
Power of two is basic. One byte consist of 8 bits. The character size in on byte. The integer size is 4 bytes. 1K = 2^10 = 1024, 1M = 2^20 = 1,048,576, 1GB = 2^30 = 1024M, etc 

## Latency numbers
A solid understanding of Latency Numbers are important when calculating the overall system performance. Here are some important latency numbers:  

Latency Comparison Numbers (~2012)  
----------------------------------  
L1 cache reference                           0.5 ns  
Branch mispredict                            5   ns  
L2 cache reference                           7   ns                      14x L1 cache  
Mutex lock/unlock                           25   ns  
Main memory reference                      100   ns                      20x L2 cache, 200x L1 cache  
Compress 1K bytes with Zippy             3,000   ns        3 us  
Send 1K bytes over 1 Gbps network       10,000   ns       10 us
Read 4K randomly from SSD*             150,000   ns      150 us          ~1GB/sec SSD  
Read 1 MB sequentially from memory     250,000   ns      250 us  
Round trip within same datacenter      500,000   ns      500 us  
Read 1 MB sequentially from SSD*     1,000,000   ns    1,000 us    1 ms  ~1GB/sec SSD, 4X memory  
Disk seek                           10,000,000   ns   10,000 us   10 ms  20x datacenter roundtrip  
Read 1 MB sequentially from disk    20,000,000   ns   20,000 us   20 ms  80x memory, 20X SSD  
Send packet CA->Netherlands->CA    150,000,000   ns  150,000 us  150 ms  

## Availablity Numbers
High availability is the ability of a system to be continuously operational for a desirably long period of time. High availability is measured as a percentage, with 100% means a service that has 0 downtime. Most services fall between 99% and 100%.
