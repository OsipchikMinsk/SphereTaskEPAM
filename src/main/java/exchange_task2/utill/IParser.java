package exchange_task2.utill;

public interface IParser <O,I> {
    O parse (I stringInput);
}
