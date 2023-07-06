import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class day_eleven {
    
    static class Monkey {
        public Queue<Long> items = new LinkedList<>();
        public boolean isMultiplyOperation;
        public long operationValue;
        public long test;
        public boolean isOldOperation;
        public int falseTest;
        public int trueTest;
        public int itemsInspected;
        
        public Monkey() {
            itemsInspected = 0;
            this.test = -1;
            this.trueTest = -1;
            this.falseTest = -1;
        }

        public long operation(long old){
            // itemsInspected += 1;

            if(isOldOperation) {
                return (old * old);
            }

            if(isMultiplyOperation){
                return (old * operationValue);
            } else {
                return (old + operationValue);
            }
        }

        public int test(long value) {
            // value = value / 3;
            if((value % test) == 0){
                return trueTest;
            } else {
                return falseTest;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader("input11"));

        String line;
        Monkey currentMonkey;
        ArrayList<Monkey> monkeys = new ArrayList<>();
        while((line = in.readLine()) != null){
            String[] split = line.split(" ");
            if(split[0].equals("Monkey")){
                currentMonkey = new Monkey();
                //starting items, operation, test
                line = in.readLine();
                String[] itemSplit = line.split(":");
                String[] startingItems = itemSplit[1].split(",");
                for(String item : startingItems){
                    // System.out.println(Integer.parseInt(item.strip()));
                    currentMonkey.items.add(Long.parseLong(item.strip()));
                }
                line = in.readLine();
                String[] operationSplit = line.split(":");
                String[] operation = operationSplit[1].split(" ");
                for(String item : operation) {
                    if("*".equals(item)) {
                        currentMonkey.isMultiplyOperation = true;
                        try{
                            currentMonkey.operationValue = Integer.parseInt(operation[operation.length - 1]);
                        } catch (Exception e){
                            currentMonkey.isOldOperation = true;
                        }   
                    } else if("+".equals(item)) {
                        currentMonkey.isMultiplyOperation = false;
                        try{
                            currentMonkey.operationValue = Integer.parseInt(operation[operation.length - 1]);
                        } catch (Exception e){
                            currentMonkey.isOldOperation = true;
                        }
                    }
                }

                line = in.readLine();
                String[] testSplit = line.split(":");
                String[] test = testSplit[1].split(" ");
                currentMonkey.test = Integer.parseInt(test[test.length - 1]);

                line = in.readLine();
                String[] trueTestSplit = line.split(":");
                String[] trueTest = trueTestSplit[1].split(" ");
                currentMonkey.trueTest = Integer.parseInt(trueTest[trueTest.length - 1]);

                line = in.readLine();
                String[] falseTestSplit = line.split(":");
                String[] falseTest = falseTestSplit[1].split(" ");
                currentMonkey.falseTest = Integer.parseInt(falseTest[falseTest.length - 1]);

                monkeys.add(monkeys.size(), currentMonkey);
            }   
        }
        in.close();
        //part 2
        long lcdPrimes = 1;
        for(Monkey m : monkeys){
            lcdPrimes *= m.test;
        }
        
        //Operation -> get new value and divide by 3 -> test -> throw to test value returned
        for(int i = 0; i < 10000; i++){
            for(Monkey m : monkeys){
                if(!m.items.isEmpty()) {
                    while(!m.items.isEmpty()) {
                        Long newVal = m.operation(m.items.poll()) % lcdPrimes;
                        m.itemsInspected++;
                        int giveToIdx = m.test(newVal);
                        monkeys.get(giveToIdx).items.add(newVal);
                    }
                }
            }
        }
        //heap sort
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(Monkey m : monkeys){
            queue.add(m.itemsInspected);
        }
        System.out.println(BigInteger.valueOf(queue.poll()).multiply(BigInteger.valueOf(queue.poll())));
    }
}