package com.algorithms.examples.trees;

public class TreeNodeDef {

  public int val;
  public TreeNodeDef left;
  public TreeNodeDef right;

  public TreeNodeDef() {}

  public TreeNodeDef(int val) {
    this.val = val;
  }

  public TreeNodeDef(int val, TreeNodeDef left, TreeNodeDef right) {
    this.val  = val;
    this.left  = left;
    this.right = right;
  }
}
