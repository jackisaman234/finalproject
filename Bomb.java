package Bombbbbb;

import java.awt.Button;
import java.util.Set;

// 每一个小方块类
public class Bomb extends Public {
	private Bomb[] Bombs;

	// 该小方块周围的八个方向上的小方块
	private Bomb east;
	private Bomb north;
	private Bomb northEast;
	private Bomb northWest;
	private Bomb south;
	private Bomb southEast;
	private Bomb southWest;
	private Bomb west;

	private boolean isBomb;// 是否是雷
	private boolean isChange;// 又没有被翻过
	private int no;// 产生的方块的编号

	// 持有所有小方块的引用,方便进行操作
	public Bomb(Bomb[] Bombs) {
		this.Bombs = Bombs;
	}

	// 按键时方块发生改变
	public boolean change() {
		this.isChange = true;
		if (isBomb) {
			return true;
		} else {
			this.setLabel(this.getNearBombNo() + "");

			return false;
		}
	}

	// 获得该小方块周围雷的数量
	public int getNearBombNo() {
		int count = 0;
		if (this.northWest.isBomb)
			count++;
		if (this.north.isBomb)
			count++;
		if (this.northEast.isBomb)
			count++;
		if (this.east.isBomb)
			count++;
		if (this.southEast.isBomb)
			count++;
		if (this.south.isBomb)
			count++;
		if (this.southWest.isBomb)
			count++;
		if (this.west.isBomb)
			count++;

		return count;
	}

	// 获得该小方块周围的小方块
	public Bomb getNearDimaond(int i) {
		int index = -1;
		switch (i) {
		case 1:// 1表示西北,2,表示北,以此类推
			index = no - 10;
			if (index < 1 || no == 19 || no == 28 || no == 37 || no == 46 || no == 55 || no == 64 || no == 73) {
				return null;
			} else {
				return Bombs[index];
			}
		case 2:
			index = no - 9;
			if (index < 1) {
				return null;
			} else {
				return Bombs[index];
			}
		case 3:
			index = no - 8;
			if (index < 1 || no == 9 || no == 18 || no == 27 || no == 36 || no == 45 || no == 54 || no == 63
					|| no == 72) {
				return null;
			} else {
				return Bombs[index];
			}
		case 4:
			index = no + 1;
			if (no == 9 || no == 18 || no == 27 || no == 36 || no == 45 || no == 54 || no == 63 || no == 72
					|| no == 81) {
				return null;
			} else {
				return Bombs[index];
			}
		case 5:
			index = no + 10;
			if (index >= 81 || no == 9 || no == 18 || no == 27 || no == 36 || no == 45 || no == 54 || no == 63
					|| no == 72 || no == 81) {
				return null;
			} else {
				return Bombs[index];
			}
		case 6:
			index = no + 9;
			if (index > 81) {
				return null;
			} else {
				return Bombs[index];
			}
		case 7:
			index = no + 8;
			if (index >= 81 || no == 1 || no == 10 || no == 19 || no == 28 || no == 37 || no == 46 || no == 55
					|| no == 64 || no == 73) {
				return null;
			} else {
				return Bombs[index];
			}
		case 8:
			index = no - 1;
			if (no == 1 || no == 10 || no == 19 || no == 28 || no == 37 || no == 46 || no == 55 || no == 64
					|| no == 73) {
				return null;
			} else {
				return Bombs[index];
			}
		}
		return null;
	}

	// 递归,set是用来装已经翻过的小方块的,不然会死循环,为什么用set,因为set是不重复的
	public void moveon(Set<Bomb> set) {

		set.add(this);// 先把自己加上
		if (this.getNorthWest() != null && this.getNorthWest().isBomb == false) {
			this.getNorthWest().change();

			if (this.getNorthWest().getNearBombNo() == 0) {
				if (set.contains(this.getNorthWest()) == false)
					this.getNorthWest().moveon(set);
			}

			set.add(this.getNorthWest());
		}

		if (this.getNorth() != null && this.getNorth().isBomb == false) {
			this.getNorth().change();
			if (this.getNorth().getNearBombNo() == 0) {
				if (set.contains(this.getNorth()) == false)
					this.getNorth().moveon(set);
			}

			set.add(this.getNorth());
		}

		if (this.getNorthEast() != null && this.getNorthEast().isBomb == false) {
			this.getNorthEast().change();
			if (this.getNorthEast().getNearBombNo() == 0) {
				if (set.contains(this.getNorthEast()) == false)
					this.getNorthEast().moveon(set);
			}

			set.add(this.getNorthEast());
		}

		if (this.getEast() != null && this.getEast().isBomb == false) {
			this.getEast().change();
			if (this.getEast().getNearBombNo() == 0) {
				if (set.contains(this.getEast()) == false)
					this.getEast().moveon(set);
			}

			set.add(this.getEast());
		}

		if (this.getSouthEast() != null && this.getSouthEast().isBomb == false) {
			this.getSouthEast().change();
			if (this.getSouthEast().getNearBombNo() == 0) {
				if (set.contains(this.getSouthEast()) == false)
					this.getSouthEast().moveon(set);
			}

			set.add(this.getSouthEast());
		}

		if (this.getSouth() != null && this.getSouth().isBomb == false) {
			this.getSouth().change();
			if (this.getSouth().getNearBombNo() == 0) {
				if (set.contains(this.getSouth()) == false)
					this.getSouth().moveon(set);
			}

			set.add(this.getSouth());
		}

		if (this.getSouthWest() != null && this.getSouthWest().isBomb == false) {
			this.getSouthWest().change();
			if (this.getSouthWest().getNearBombNo() == 0) {
				if (set.contains(this.getSouthWest()) == false)
					this.getSouthWest().moveon(set);
			}

			set.add(this.getSouthWest());
		}

		if (this.getWest() != null && this.getWest().isBomb == false) {
			this.getWest().change();
			if (this.getWest().getNearBombNo() == 0) {
				if (set.contains(this.getWest()) == false)
					this.getWest().moveon(set);
			}

			set.add(this.getWest());
		}
	}

}
