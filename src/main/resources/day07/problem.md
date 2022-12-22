# Day 7 - No Space Left On Device

You try to run a system update on the device but there is no more space left.

Your objective is to free some space on the device.

Your input the terminal output of the device.

```
$ cd /
$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
$ cd a
$ ls
dir e
29116 f
2557 g
62596 h.lst
$ cd e
$ ls
584 i
$ cd ..
$ cd ..
$ cd d
$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
```

Given the input you can determine that the filesystem content looks like this:

```
- / (dir)
  - a (dir)
    - e (dir)
      - i (file, size=584)
    - f (file, size=29116)
    - g (file, size=2557)
    - h.lst (file, size=62596)
  - b.txt (file, size=14848514)
  - c.dat (file, size=8504156)
  - d (dir)
    - j (file, size=4060174)
    - d.log (file, size=8033020)
    - d.ext (file, size=5626152)
    - k (file, size=7214296)
```

First you need to determine the total size of each directory.

Part one: Find all the directories with a total size of at most **100_000**, then calculate the sum of their sizes. 

Part two:

The total disk space available is **70_000_000**.

To run the update, you need at least **30_000_000**.

Find the smallest directory that, if deleted, would free enough space to run the update.

Return the size of that directory.