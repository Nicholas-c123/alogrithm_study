import java.util.Arrays;

public class HeapSort {
	public static void heapSort(int[] data){
		//构建最大堆，从最底层子树开始
		for (int i = data.length /2 -1; i >=0; i--){//data.length/2-1 == (data.length - 1 -1)/2
			heapAdjust(data, i, data.length);
		}
		//交换最大元素data[0]至数组尾部 从0到data.length-2 heap sort
		
		for (int i = data.length-1; i > 0 ;i--){
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			heapAdjust(data, 0, i);
		}
	}
	
	private static void heapAdjust(int[] data, int s, int end){
		int temp = data[s];
		//临界值是heap的左节点在范围内(<end)同时要考虑右节点越界的情况
		for (int i = 2 * s +1; i < end; i = 2 * i + 1){
			//取两个子节点中的较大值
			if (i+1 < end && data[i+1] > data[i])
				i++;
			//找到data[s]合适的位置
			if (temp <= data[i]){
				//将更大的节点上移至s
				data[s] = data[i];
				//继续调整heapfix子树
				s = i;
			}else
				break;
		}
		//把原来的data[s]放到合适的位置
		data[s] = temp;
	}
	
	public static void main(String[] args){
		int[] data = {3, 6,9, 10, -1, -2,2000,-5,0,4};
		heapSort(data);
		System.out.println(Arrays.toString(data));
	}
}
