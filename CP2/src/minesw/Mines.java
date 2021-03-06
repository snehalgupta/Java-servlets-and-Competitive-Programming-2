package minesw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Mines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Reader.init(System.in);    
	    try{ 
	    	int n=Reader.nextInt();
			int m=Reader.nextInt();
			char[][] arr = new char[n][m];
			for(int i=0;i<n;i++) {
				String q=Reader.next();
				if(q.length() == m) {
				for(int j=0;j<m;j++) {
					arr[i][j] = q.charAt(j);
				}
				}
				else {
					//int diff = m - q.length();
					for(int e=q.length();e<m;e++) {
						arr[i][e] = ' ';
					}
				}
			}
			boolean flag = true;
			for(int k=0;k<n;k++) {
				for(int l=0;l<m;l++) {
					if(Character.isDigit(arr[k][l])) {
					int count = 0;
					
					if(k-1 >= 0) {
						if(l-1 >= 0) {
						if(arr[k-1][l-1] == '*') {
							count+=1;
						}
						}
						if(arr[k-1][l] == '*') {
							count+=1;
						}
						if(l+1 < m) {
							if(arr[k-1][l+1] == '*') {
								count+=1;
							}
						}
					}
					
					if(k+1 < n) {
						if(l-1 >= 0) {
							if(arr[k+1][l-1] == '*') {
								count+=1;
							}
							}
							if(arr[k+1][l] == '*') {
								count+=1;
							}
							if(l+1 < m) {
								if(arr[k+1][l+1] == '*') {
									count+=1;
								}
							}
					}
					if(l-1 >= 0) {
						if(arr[k][l-1] == '*') {
							count+=1;
						}
					}
					if(l+1<m) {
						if(arr[k][l+1] == '*') {
							count+=1;
						}
					}
					int ty = Character.getNumericValue(arr[k][l]);
					if(count != ty) {
						//System.out.println(k+" "+l+" "+count+" "+arr[k][l]);
						flag = false;
						break;
					}
					
					
					
					}
					else if(arr[k][l] == '.') {
						int count=0;
						if(k-1 >= 0) {
							if(l-1 >= 0) {
							if(arr[k-1][l-1] != '*') {
								count+=1;
							}
							}
							if(arr[k-1][l] != '*') {
								count+=1;
							}
							if(l+1 < m) {
								if(arr[k-1][l+1] != '*') {
									count+=1;
								}
							}
						}
						
						if(k+1 < n) {
							if(l-1 >= 0) {
								if(arr[k+1][l-1] != '*') {
									count+=1;
								}
								}
								if(arr[k+1][l] != '*') {
									count+=1;
								}
								if(l+1 < m) {
									if(arr[k+1][l+1] != '*') {
										count+=1;
									}
								}
						}
						if(l-1 >= 0) {
							if(arr[k][l-1] != '*') {
								count+=1;
							}
						}
						if(l+1<m) {
							if(arr[k][l+1] != '*') {
								count+=1;
							}
						}
						if(count != 8) {
							flag = false;
							//System.out.println(k+" "+l);
							break;
						}
					}
					
				}
				if(flag == false) {
					break;
				}
			}
			if(flag == true) {
			System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
	    } catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}