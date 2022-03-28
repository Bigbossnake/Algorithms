    List<List<Integer>> res = new LinkedList<>();

    void backtrack(int[] nums, LinkedList<Integer> track) {
        // trigger the ending condition
        if (track.size() == 3) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // exclud illegal selections
            if (track.contains(nums[i]))
                continue;
            // select
            track.add(nums[i]);
            // go to the next decision tree
            backtrack(nums, track);
            // deselect
            track.removeLast();
        }
    }

    /* main function, input a uique set of numbers and return all permutations of them */
    List<List<Integer>> permute(int[] nums) {
        // record "path"
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }