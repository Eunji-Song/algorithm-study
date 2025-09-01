/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
        public ListNode middleNode(ListNode head) {
            // 1. 길이 구하기
            int length = 0;
            ListNode temp = head;
            
            while (temp != null) {
                length++;
                temp = temp.next;
            }

            // 2. 중간 위치 계산
            int mid = length / 2 + 1;  // 홀수/짝수 모두 동일하게 처리 가능

            // 3. mid번째 노드까지 이동
            temp = head;
            for (int i = 1; i < mid; i++) {
                temp = temp.next;
            }

            // 4. 해당 노드 반환
            return temp;
        }
}