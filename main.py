import random
from collections import defaultdict

n = 45
seq_length = 6
match_times = 6
max_generation = 1000000000000

sequence_count = defaultdict(int)
count = 0

while count < max_generation:
    sequence = random.sample(range(1, n + 1), seq_length)
    sequence.sort()
    seq = tuple(sequence)
    sequence_count[seq] += 1
    if sequence_count[seq] == match_times:
        print(count)
        print(seq)
        break
    count += 1

print("Done")