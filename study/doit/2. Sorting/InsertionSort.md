## InsertionSort

이미 정렬된 데이터 범위에 정렬되지 않은 데이터를 적절한 위치에 삽입하여 정렬

시간복잡도: O(n²)

1. index 1부터 시작한다.
2. 현재 index의 값을 key로 저장한다.
3. key 앞쪽의 정렬된 index 구간을 뒤에서부터 확인한다.
4. key보다 큰 값이 있는 동안, 해당 값의 index를 한 칸씩 오른쪽으로 shift한다.
5. 더 이상 shift할 수 없으면, 그 index 위치에 key를 삽입한다.
6. 이 과정을 마지막 index까지 반복한다.





