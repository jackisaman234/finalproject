package Bombbbbb;

import java.awt.Button;

public class Public  extends Button{
	protected Bomb[] Bombs;

	protected Bomb east;
	protected Bomb north;
	protected Bomb northEast;
	protected Bomb northWest;
	protected Bomb south;
	protected Bomb southEast;
	protected Bomb southWest;
	protected Bomb west;
    
	protected boolean isBomb;
	protected boolean isChange;
	protected int no;
	
	public Bomb[] getBombs() {
		return Bombs;
	}
	public void setBombs(Bomb[] bombs) {
		Bombs = bombs;
	}
	public Bomb getEast() {
		return east;
	}
	public void setEast(Bomb east) {
		this.east = east;
	}
	public Bomb getNorth() {
		return north;
	}
	public void setNorth(Bomb north) {
		this.north = north;
	}
	public Bomb getNorthEast() {
		return northEast;
	}
	public void setNorthEast(Bomb northEast) {
		this.northEast = northEast;
	}
	public Bomb getNorthWest() {
		return northWest;
	}
	public void setNorthWest(Bomb northWest) {
		this.northWest = northWest;
	}
	public Bomb getSouth() {
		return south;
	}
	public void setSouth(Bomb south) {
		this.south = south;
	}
	public Bomb getSouthEast() {
		return southEast;
	}
	public void setSouthEast(Bomb southEast) {
		this.southEast = southEast;
	}
	public Bomb getSouthWest() {
		return southWest;
	}
	public void setSouthWest(Bomb southWest) {
		this.southWest = southWest;
	}
	public Bomb getWest() {
		return west;
	}
	public void setWest(Bomb west) {
		this.west = west;
	}
	public boolean isBomb() {
		return isBomb;
	}
	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}
	public boolean isChange() {
		return isChange;
	}
	public void setChange(boolean isChange) {
		this.isChange = isChange;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
}
