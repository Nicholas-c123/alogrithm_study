import java.util.Arrays;

public class HeapSort {
	public static void heapSort(int[] data){
		//�������ѣ�����ײ�������ʼ
		for (int i = data.length /2 -1; i >=0; i--){//data.length/2-1 == (data.length - 1 -1)/2
			heapAdjust(data, i, data.length);
		}
		//�������Ԫ��data[0]������β�� ��0��data.length-2 heap sort
		
		for (int i = data.length-1; i > 0 ;i--){
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			heapAdjust(data, 0, i);
		}
	}
	
	private static void heapAdjust(int[] data, int s, int end){
		int temp = data[s];
		//�ٽ�ֵ��heap����ڵ��ڷ�Χ��(<end)ͬʱҪ�����ҽڵ�Խ������
		for (int i = 2 * s +1; i < end; i = 2 * i + 1){
			//ȡ�����ӽڵ��еĽϴ�ֵ
			if (i+1 < end && data[i+1] > data[i])
				i++;
			//�ҵ�data[s]���ʵ�λ��
			if (temp <= data[i]){
				//������Ľڵ�������s
				data[s] = data[i];
				//��������heapfix����
				s = i;
			}else
				break;
		}
		//��ԭ����data[s]�ŵ����ʵ�λ��
		data[s] = temp;
	}
	
	public static void main(String[] args){
		int[] data = {3, 6,9, 10, -1, -2,2000,-5,0,4};
		heapSort(data);
		System.out.println(Arrays.toString(data));
	}
}
