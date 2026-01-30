class Solution {
   
    public int romanToInt(String s) {
        
        if (s == null || s.isEmpty() || !isValid(s)) {
            return 0; 
        }

      
        return calculate(s);
    }

    
    private boolean isValid(String s) {
        for (char c : s.toCharArray()) {
            if (getValue(c) == -1) return false;
        }
        return true;
    }

   
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }

    
    private int calculate(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = getValue(s.charAt(i));

            if (i + 1 < s.length()) {
                int next = getValue(s.charAt(i + 1));
                if (current < next) {
                    total -= current;
                } else {
                    total += current;
                }
            } else {
                total += current;
            }
        }
        return total;
    }
}