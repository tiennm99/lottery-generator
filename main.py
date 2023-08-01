import random
from collections import defaultdict

n = 55
seq_length = 7
match_times = 7

sequence_count = defaultdict(int)

while True:
    sequence = random.sample(range(1, n + 1), seq_length)
    sequence.sort()
    seq = tuple(sequence)
    sequence_count[seq] += 1
    if sequence_count[seq] == match_times:
        print(seq)
        break
