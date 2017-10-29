package demo;

import java.util.List;
import java.util.ArrayList;

public class Field {

	private int level;
	private String name;
	private int startPos;
	private int endPos;
	private int length;
	private String pictureClause;
	private List<Integer> children;
	private int parent;
	private boolean redefines;
	private boolean renames;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStartPos() {
		return startPos;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	public int getEndPos() {
		return endPos;
	}
	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getPictureClause() {
		return pictureClause;
	}
	public void setPictureClause(String pictureClause) {
		this.pictureClause = pictureClause;
	}
	public List<Integer> getChildren() {
		return children;
	}
	public void setChildren(List<Integer> children) {
		this.children = children;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public boolean isRedefines() {
		return redefines;
	}
	public void setRedefines(boolean redefines) {
		this.redefines = redefines;
	}
	public boolean isRenames() {
		return renames;
	}
	public void setRenames(boolean renames) {
		this.renames = renames;
	}
}
