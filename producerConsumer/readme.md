# Producer - Consumer | Bounded buffer | Bounded queue

# Requirements
1. Blocks producer if no capacity left
2. Block consumer if no item left
3. remove the blocking whenever these conditions change

1. One producer and one consumer
# Approach:
One normal queue (LinkedList) used and take a lock whenever a adding/removing item
producer take write lock -> check if capacity is there
consumer take read lock -> check if item is there before taking a read lock
