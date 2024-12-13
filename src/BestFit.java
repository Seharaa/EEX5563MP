import java.util.Scanner;

public class BestFit{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of memory blocks: ");
        int blockCount = scanner.nextInt();
        int[] blocks = new int[blockCount];

        System.out.println("Enter sizes of memory blocks: ");
        for (int i = 0; i < blockCount; i++) {
            blocks[i] = scanner.nextInt();
        }

        System.out.print("Enter number of memory requests: ");
        int requestCount = scanner.nextInt();
        int[] requests = new int[requestCount];

        System.out.println("Enter sizes of memory requests: ");
        for (int i = 0; i < requestCount; i++) {
            requests[i] = scanner.nextInt();
        }

        bestFit(blocks, requests);
    }

    public static void bestFit(int[] blocks, int[] requests) {
        int[] allocation = new int[requests.length];

        for (int i = 0; i < allocation.length; i++) {
            allocation[i] = -1;
        }

        for (int i = 0; i < requests.length; i++) {
            int bestIndex = -1;


            for (int j = 0; j < blocks.length; j++) {
                if (blocks[j] >= requests[i]) {
                    if (bestIndex == -1 || blocks[j] < blocks[bestIndex]) {
                        bestIndex = j;
                    }
                }
            }

            if (bestIndex != -1) {
                allocation[i] = bestIndex;
                blocks[bestIndex] -= requests[i];
            }
        }

        System.out.println("\nRequest No.\tRequest Size\tBlock Allocated");
        for (int i = 0; i < requests.length; i++) {
            System.out.println((i + 1) + "\t\t\t" + requests[i] + "\t\t\t\t" +
                    (allocation[i] == -1 ? "Not Allocated" : "Block " + (allocation[i] + 1)));
        }

        System.out.println("\nRemaining Memory in Blocks:");
        for (int i = 0; i < blocks.length; i++) {
            System.out.println("Block " + (i + 1) + ": " + blocks[i]);
        }
    }
}
