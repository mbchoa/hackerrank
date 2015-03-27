package cavitymap;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	private static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args) {
		int mapSize = Integer.parseInt(stdin.nextLine());
		solve(mapSize);
	}
	
	private static void solve(int size){
		char[][] cavityMap = createMap(size);
		cavityMap = fillMap(cavityMap);
		List<Point> cavityLocations = getCavityCoordinates(cavityMap);
		cavityMap = markCavitiesAtLocations(cavityMap, cavityLocations);
		printMap(cavityMap);
	}
	
	private static char[][] createMap(int size){
		return new char[size][size];
	}

	private static char[][] fillMap(char[][] map){
		for(int i = 0; i < map.length; i++){
			String line = stdin.nextLine();
			char[] lineChars = line.toCharArray();
			for(int j = 0; j < lineChars.length; j++){
				map[i][j] = lineChars[j];
			}
		}
		return map;
	}
	
	private static List<Point> getCavityCoordinates(char[][] map){
		List<Point> cavityLocations = new ArrayList<Point>();
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map.length; j++){
				Point toothLocation = new Point(i, j);
				if(isBoundary(toothLocation, map.length))
					continue;
				if(isCavity(toothLocation, map))
					cavityLocations.add(toothLocation);
			}
		}
		return cavityLocations;
	}
	
	private static Boolean isBoundary(Point point, int maxMapSize){
		return (point.x == 0) || (point.x == maxMapSize-1) || (point.y == 0) || (point.y == maxMapSize-1);
	}
	
	private static Boolean isCavity(Point point, char[][] map){
		int leftToothDepth = Character.getNumericValue(map[point.x-1][point.y]);
		int topToothDepth = Character.getNumericValue(map[point.x][point.y-1]);
		int rightToothDepth = Character.getNumericValue(map[point.x+1][point.y]);
		int bottomToothDepth = Character.getNumericValue(map[point.x][point.y+1]);
		int pointToothDepth = Character.getNumericValue(map[point.x][point.y]);
		return (leftToothDepth < pointToothDepth) && (topToothDepth < pointToothDepth) && (rightToothDepth < pointToothDepth) && (bottomToothDepth < pointToothDepth);
	}
	
	private static char[][] markCavitiesAtLocations(char[][] cavityMap, List<Point> cavityLocations){
		for(int i = 0; i < cavityLocations.size(); i++){
			Point cavityLocation = cavityLocations.get(i);
			cavityMap[cavityLocation.x][cavityLocation.y] = 'X';
		}
		return cavityMap;
	}
	
	private static void printMap(char[][] map){
		for(int i = 0; i < map.length; i++){
			String line = "";
			for(int j = 0; j < map.length; j++)
				line += map[i][j];
			System.out.println(line);
		}
	}
}
