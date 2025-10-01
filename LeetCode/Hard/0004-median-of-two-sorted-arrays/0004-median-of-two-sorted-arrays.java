class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1. nums1이 더 짧은 배열이 되도록 보장
        // → 이진 탐색 범위를 최소화하기 위함
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        // 2. 이진 탐색 초기 설정
        int left = 0;
        int right = m;
        
        // 3. Binary Search 시작!
        while (left <= right) {
            // nums1의 분할 위치
            int partition1 = (left + right) / 2;
            
            // nums2의 분할 위치 (왼쪽 그룹 크기를 맞추기 위해)
            int partition2 = (m + n + 1) / 2 - partition1;
            
            // 4. 분할선 주변의 값들 구하기
            // (경계 처리: 범위를 벗어나면 무한대/무한소 사용)
            int maxLeft1 = (partition1 == 0) ? 
                Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? 
                Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? 
                Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? 
                Integer.MAX_VALUE : nums2[partition2];
            
            // 5. 올바른 분할인지 확인
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // 중앙값 찾음! \U0001f389
                
                // 전체 길이가 짝수인 경우
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + 
                            Math.min(minRight1, minRight2)) / 2.0;
                }
                // 전체 길이가 홀수인 경우
                else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            }
            // 6. 분할 위치 조정
            else if (maxLeft1 > minRight2) {
                // nums1의 왼쪽 값이 너무 크다 → 왼쪽으로 이동
                right = partition1 - 1;
            }
            else {
                // nums1의 왼쪽 값이 너무 작다 → 오른쪽으로 이동
                left = partition1 + 1;
            }
        }
        
        // 여기까지 오면 안 됨 (문제 조건상 항상 답이 있음)
        return 0.0;
    }
}