//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
//Find all unique triplets in the array which gives the sum of zero.

//Example
//For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
//(-1, 0, 1)
//(-1, -1, 2)


    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();

        if (numbers == null || numbers.length < 3){
            return result;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            int target = -numbers[i];

            twoSum(numbers, left, right, target, result);
        }
        return result;
    }

    private void twoSum(int[] numbers, int left, int right, int target, List<List<Integer>> result){
        while (left < right){
            if (left < right && numbers[left] + numbers[right] == target){
                ArrayList<Integer> three = new ArrayList<>();
                three.add(-target);
                three.add(numbers[left]);
                three.add(numbers[right]);
                result.add(three);
                left++;
                right--;
                
                while (left < right && numbers[left] == numbers[left - 1]){
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]){
                    right--;
                }
            }
            
            else if (left < right && numbers[left] + numbers[right] < target){
                left++;
            }
            else {
                right--;
            }
        }
    }
    
    
