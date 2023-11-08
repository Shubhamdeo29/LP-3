import java.util.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class HuffmanNode {
    int frequency;
    char data;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.frequency - y.frequency;
    }
}

public class huffmann2 {

    public static void printCodes(HuffmanNode root, String s, HashMap<Character, String> codes) {
        
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && Character.isLetter(root.data)) {
            codes.put(root.data, s);
            return;
        }
        printCodes(root.left, s + "0", codes);
        printCodes(root.right, s + "1", codes);
    }

    public static HashMap<Character, String> huffmanCodes(HashMap<Character, Integer> freq) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(freq.size(), new MyComparator());

        for (char c : freq.keySet()) {
            HuffmanNode node = new HuffmanNode();
            node.data = c;
            node.frequency = freq.get(c);
            node.left = null;
            node.right = null;
            priorityQueue.add(node);
        }
    
        while (priorityQueue.size() > 1) {
            HuffmanNode x = priorityQueue.poll();
            HuffmanNode y = priorityQueue.poll();
            HuffmanNode newNode = new HuffmanNode();
            newNode.frequency = x.frequency + y.frequency;
            newNode.data = '-';
            newNode.left = x;
            newNode.right = y;
            priorityQueue.add(newNode);
        }

        HuffmanNode root = priorityQueue.peek();

        HashMap<Character, String> codes = new HashMap<>();
        printCodes(root, "", codes);
        return codes;
    }

    public static void main(String[] args) {
        //String input = "BCCABBDDAECCBBAEDDCC"; // Input string
        //String input = "AAAABBBBBBBCCCDDEEEE";
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter String: ");
        String input= sc.nextLine();
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, String> codes = huffmanCodes(freq);

        System.out.println("Character  Frequency  Huffman Code");
        for (char c : codes.keySet()) {
            System.out.println(c + "          " + freq.get(c) + "          " + codes.get(c));
        }
    }
}

