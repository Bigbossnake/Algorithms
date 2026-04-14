/***
 * You are given an absolute path for a Unix-style file system, which always begins with a slash '/'.
 * Your task is to transform this absolute path into its simplified canonical path.
 *
 * The rules of a Unix-style file system are as follows:
 *
 * A single period '.' represents the current directory.
 * A double period '..' represents the previous/parent directory.
 * Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
 *
 * Any sequence of periods that does not match the rules above should be treated as a valid directory or file name.
 * For example, '...' and '....' are valid directory or file names.
 * The simplified canonical path should follow these rules:
 *
 * The path must start with a single slash '/'.
 * Directories within the path must be separated by exactly one slash '/'.
 * The path must not end with a slash '/', unless it is the root directory.
 * The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
 *
 * Return the simplified canonical path.
 */
package com.problem.solving.leetcode.problems.strings;

import java.util.LinkedList;

public class SimplifyPath {

  public String simplifyPath(String path) {
    LinkedList<String> folderNames = new LinkedList<>();
    String[] pathTokens = path.split("/");

    for (int i = 0; i < pathTokens.length; i++) {
      String currentFolder = pathTokens[i];

      if (currentFolder.isEmpty() || currentFolder.equals(".")) {
        continue;
      }

      else if (currentFolder.equals("..")) {

        if (!folderNames.isEmpty()) {
          folderNames.removeLast();
        }

        continue;
      }

      folderNames.add(currentFolder);
    }

    StringBuilder canonicalPath = new StringBuilder();
    for (String folder : folderNames) {
      canonicalPath.append("/");
      canonicalPath.append(folder);
    }

    return (!canonicalPath.isEmpty()) ? canonicalPath.toString() : "/";
  }

  public static void main(String[] args) {
    SimplifyPath simplifyPath = new SimplifyPath();
    String path = "/../";

    System.out.println(simplifyPath.simplifyPath(path));
  }
}
