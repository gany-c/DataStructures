"""
Given a sentence, find all pairs of words whose counts sum to given target.
Example - “I am solving this word count problem. I like this and I like other word games!” and target = 5 (I, word), (I, this), (I, like).
First pass - Word to Count map - ignore words with count greater than target
Second pass - traverse the map, and check if the counts sum up to the target
"""


def get_count_map(sentence: str, target: int) -> {}:
    tokens = sentence.split()
    count_map = {}

    for word in tokens:
        if not word in count_map:
            count_map[word] = 1
        else:
            count_map[word] += 1
    return count_map


def get_reverse_map(count_map: {}):
    entry_list = []
    reverse_map = {}

    for key in count_map:
        count = count_map[key]
        entry_list.append((key, count))

        if not count in reverse_map:
            reverse_map[count] = [key, ]
        else:
            reverse_map[count].append(key)

    return entry_list, reverse_map


def update_output_and_map(entry: (), reverse_map: {}, output: [], target: int):
    count = entry[1]
    compliment = target - count
    # count and compliment can end up being the same

    if compliment in reverse_map:
        list_1 = reverse_map[count]
        list_2 = reverse_map[compliment]

        for i in list_1:
            for j in list_2:
                if i != j:
                    output.append((i, j))
        del reverse_map[compliment]

    if count != compliment:
        # deleting the same key results in key error
        del reverse_map[count]


def find_pair_count_sums_to_target(sentence: str, target: int) -> [()]:
    print("hi Gany")

    if target <= 1 or not sentence:
        return

    count_map = get_count_map(sentence, target)
    entry_list, reverse_map = get_reverse_map(count_map)
    output = []

    for entry in entry_list:
        if entry[1] in reverse_map:
            update_output_and_map(entry, reverse_map, output, target)

    return output


x = find_pair_count_sums_to_target("I am solving this word count problem I like this and I like other word games", 7)
print(x)
