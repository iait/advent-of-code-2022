# Day 11 - Monkey in the Middle

The input will be a list of notes describing how monkeys behave inspecting items.

* **Starting items** lists your worry level for each item the monkey is currently holding in the order they will be inspected.
* **Operation** shows how your worry level changes as that monkey inspects an item.
* **Test** shows how the monkey uses your worry level to decide where to throw an item next.
  * **If true** shows what happens with an item if the Test was true. 
  * **If false** shows what happens with an item if the Test was false.

After each monkey inspects an item but before it tests your worry level, the worry level is **divided by three and rounded down**.

```
Monkey 0:
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3

Monkey 1:
  Starting items: 54, 65, 75, 74
  Operation: new = old + 6
  Test: divisible by 19
    If true: throw to monkey 2
    If false: throw to monkey 0

Monkey 2:
  Starting items: 79, 60, 97
  Operation: new = old * old
  Test: divisible by 13
    If true: throw to monkey 1
    If false: throw to monkey 3

Monkey 3:
  Starting items: 74
  Operation: new = old + 3
  Test: divisible by 17
    If true: throw to monkey 0
    If false: throw to monkey 1
```

You're going to have to focus on the two most active monkeys if you want any hope of getting your stuff back.

### Part One

The objective is to count the total number of times each monkey inspects items over 20 rounds, and multiply the two greater numbers.

That is called the level of **monkey business**.

### Part two

The objective is to find the level of monkey business after 10_000 round, but without dividing by three on each inspection.
