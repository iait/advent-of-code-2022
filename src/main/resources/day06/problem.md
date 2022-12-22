# Day 6 - Tuning Trouble

One Elf gives you a malfunctioning handheld device for communication.

The device receives a series of seemingly-random characters one at a time.

To fix communication, you need to add a subroutine that detects a **start-of-packet marker**.

The marker is a sequence of **four characters that are all different**.

Part one objective: report the number of characters from the beginning of the buffer to the end of the first such four-character marker.

```
mjq[jpqm]gbljsphdztnvjfqwrcgsmlb -> 7
```

The marker of the message is now a sequence of **14 distinct characters**.

Part two objective: find the message marker.
