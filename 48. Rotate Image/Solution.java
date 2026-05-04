
//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         int[][] matrix = {
//             {1, 2, 3, 4},
//             {5, 6, 7, 8},
//             {9, 10, 11, 12},
//             {13, 14, 15, 16}
//         };
//         solution.rotate(matrix);
//         // The matrix should now be rotated in place
//     }
//     public void rotate(int[][] matrix) {
//         ArrayList<Integer> arr1 = new ArrayList<Integer>();
//         for(int i=0; i<matrix.length;i++){
//             for(int j=matrix.length-1;j>=0;j--){
//                 System.out.print("index ["+j+","+i+"] = "+matrix[j][i]+" ");
//                 arr1.add(matrix[j][i]);
//             }
//         }
//         System.out.println(arr1);
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix.length;j++){
//                 matrix[i][j] = arr1.get(i*matrix.length+j);
//             }
//         }
//         System.out.println("Rotated matrix:");
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix.length;j++){
//                 System.out.print(matrix[i][j]+" ");
//             }
//             System.out.println();
//         }
//     }
// }

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        solution.rotate(matrix);
        // The matrix should now be rotated in place
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        // (Swap matrix[i][j] with matrix[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                System.err.println("temp"+temp);
                matrix[i][j] = matrix[j][i];
                System.err.println("matrix[i][j]"+matrix[i][j]);
                matrix[j][i] = temp;
                System.err.println("matrix[j][i]"+matrix[j][i]);
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        System.err.println("Rotated matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.err.print(matrix[i][j] + " ");
            }
            System.err.println();
        }
    }
}