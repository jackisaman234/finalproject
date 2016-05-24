package Bombbbbb;

import java.awt.Button;
import java.util.Set;

// ÿһ��С������
public class Bomb extends Public {
	private Bomb[] Bombs;

	// ��С������Χ�İ˸������ϵ�С����
	private Bomb east;
	private Bomb north;
	private Bomb northEast;
	private Bomb northWest;
	private Bomb south;
	private Bomb southEast;
	private Bomb southWest;
	private Bomb west;

	private boolean isBomb;// �Ƿ�����
	private boolean isChange;// ��û�б�����
	private int no;// �����ķ���ı��

	// ��������С���������,������в���
	public Bomb(Bomb[] Bombs) {
		this.Bombs = Bombs;
	}

	// ����ʱ���鷢���ı�
	public boolean change() {
		this.isChange = true;
		if (isBomb) {
			return true;
		} else {
			this.setLabel(this.getNearBombNo() + "");

			return false;
		}
	}

	// ��ø�С������Χ�׵�����
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

	// ��ø�С������Χ��С����
	public Bomb getNearDimaond(int i) {
		int index = -1;
		switch (i) {
		case 1:// 1��ʾ����,2,��ʾ��,�Դ�����
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

	// �ݹ�,set������װ�Ѿ�������С�����,��Ȼ����ѭ��,Ϊʲô��set,��Ϊset�ǲ��ظ���
	public void moveon(Set<Bomb> set) {

		set.add(this);// �Ȱ��Լ�����
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
