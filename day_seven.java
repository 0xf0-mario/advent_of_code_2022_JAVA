import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class day_seven {
    static class Dir{
        private long size;
        private String name;
        private Dir parent;
        private ArrayList<Dir> children;

        public Dir(long size, String name, Dir parent) {
            this.size = size;
            this.name = name;
            this.parent = parent;
            this.children = new ArrayList<Dir>();
        }

        public Dir(String name) {
            this.name = name;
            this.children = new ArrayList<Dir>();
            this.size = 0;
            this.parent = null;
        }

        public long getSize() {
            long ans = size;
            for(Dir child : children) {
                ans += child.getSize();
            }
            return ans;
        }

        public void addSize(long size) {
            this.size += size;
        }

        public long size() {
            return size;
        }

        public String getName() {
            return name;
        }

        public Dir getParent() {
            return parent;
        }

        public void setParent(Dir parent) {
            this.parent = parent;
        }

        public ArrayList<Dir> getChildren() {
            return children;
        }

        public void addChild(Dir child) {
            children.add(child);
        }
    }

    public static void main(String[] args) throws Exception {
        // String input = """
                
        //         """;
        BufferedReader in = new BufferedReader(new FileReader("./input7"));
        Dir root = new Dir("/");
        Dir currentDir = root;
        List<Dir> dirs = new ArrayList<Dir>(); 
        String line;
        while((line = in.readLine()) != null) {
            String[] split = line.split(" ");
            String caseLine = split[0];

            switch(caseLine) {
                case "$":
                //handle command
                    if("cd".equals(split[1])) {
                        if("/".equals(split[2])) {
                            currentDir = root;
                        } else if ("..".equals(split[2])) {
                           currentDir = currentDir.getParent();     
                        } else {
                            for(Dir child : currentDir.getChildren()) {
                                if(child.getName().equals(split[2])) {
                                    currentDir = child;
                                    break;
                                }
                            }
                        }

                    }
                break;
                case "dir":
                    Dir dir = new Dir(split[1]);
                    dir.setParent(currentDir);
                    currentDir.addChild(dir);
                    dirs.add(dir);
                    break;
                default:
                    //add file size to currenty directory
                    currentDir.addSize(Long.parseLong(split[0]));
            }

        }
        in.close();
        long totalSize = root.getSize();
        long unused = 70000000 - totalSize;
        long required = 30000000 - unused;
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();

        // long ans = 0;
        for(Dir d : dirs) {
            long size = d.getSize();
            if(size > required){
                minHeap.offer(size);
            }
        }
        System.out.println(minHeap.poll());
    }


}
