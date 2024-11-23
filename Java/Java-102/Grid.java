import java.util.ArrayList;


public  class Grid<T> {
    private final ArrayList<ArrayList<T>> grid;
    public final int sideLength;
    public static int maxSideLength;

    public Grid(int sideLength, T defaultVal) {
		this.sideLength = sideLength;
		this.grid = new ArrayList<ArrayList<T>>(sideLength);
        
		for (int i = 0; i < sideLength; i++) {
			grid.add(new ArrayList<>(sideLength));
			for (int j = 0; j < sideLength; j++) {
				grid.get(i).add(defaultVal);
			}
		}
        if (maxSideLength < sideLength){
            maxSideLength = sideLength;
        }
	}
    public static int maxSideLength(){
        return maxSideLength;
    }

	public T get(int row, int col) {
		return grid.get(row).get(col);
	}

	public void set(int row, int col, T val) {
		grid.get(row).set(col, val);
	}

	@Override
	public String toString() {
		String str = "";
		for (ArrayList<T> row : grid) {
			for (T element : row) {
				str += element + " ";
			}
			str += "\n";
		}
		return str;
	}
    public ArrayList<T> diagonal(){
        ArrayList<T> arr = new ArrayList<>();
        for (int i = 0; i < sideLength; i++){
            arr.add(grid.get(i).get(i));
        }
        return arr;
    }
}