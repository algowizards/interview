public class Chap1ArraysAndStringsTest{

	public static void main(String args[]){
		
		//TestQ1IsUnique();
		//TestQ1IsUniqueWithoutAdditionalDS();
		//TestQ2IsPerumutation();
		//TestURLify();
		//TestPalindromePermutation();
		//TestOneEditAway();
		//TestCompress();
		TestZeroOutMatrix();
	}
	
	public static void TestQ1IsUnique(){
		
		String testString = "";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));
		
		testString = null;
		System.out.println("Is String : \""+ testString + "\"  made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));

		testString = "a";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));

		testString = "abc";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));

		testString = "abcb";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));

		testString = "abc";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));

		testString = "Aabc";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));
		
		testString = "abc%$^&";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));
		
		testString = "abc%$^&&";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));

		testString = "abca";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));
		
		testString = "    ";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUnique(testString));
		
	}
	
	public static void TestQ1IsUniqueWithoutAdditionalDS(){
		
		String testString = "";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));
		
		testString = null;
		System.out.println("Is String : \""+ testString + "\"  made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));

		testString = "a";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));

		testString = "abc";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));

		testString = "abcb";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));

		testString = "abc";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));

		testString = "Aabc";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));
		
		testString = "abc%$^&";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));
		
		testString = "abc%$^&&";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));

		testString = "abca";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));
		
		testString = "    ";
		System.out.println("Is String : "+ testString + " is made of unique characters? " + Chap1ArraysAndStrings.Q1_IsUniqueWithoutAdditionalDS(testString));

	}
	
	public static void TestQ2IsPerumutation(){
		
		String a= "";
		String b = "";
		System.out.println("Is String : "+ a + " is a permutation of String: " + b +"? " + Chap1ArraysAndStrings.Q2IsPerumutation(a, b));
		
		a = "a";
		b = "a";
		System.out.println("Is String : "+ a + " is a permutation of String: " + b +"? " + Chap1ArraysAndStrings.Q2IsPerumutation(a, b));
		
		a = "a";
		b = "b";
		System.out.println("Is String : "+ a + " is a permutation of String: " + b +"? " + Chap1ArraysAndStrings.Q2IsPerumutation(a, b));

		a = "abc";
		b = "cab";
		System.out.println("Is String : "+ a + " is a permutation of String: " + b +"? " + Chap1ArraysAndStrings.Q2IsPerumutation(a, b));
		
		a = "abba";
		b = "baab";
		System.out.println("Is String : "+ a + " is a permutation of String: " + b +"? " + Chap1ArraysAndStrings.Q2IsPerumutation(a, b));

		a = "abc";
		b = "abd";
		System.out.println("Is String : "+ a + " is a permutation of String: " + b +"? " + Chap1ArraysAndStrings.Q2IsPerumutation(a, b));

		a = "abcd";
		b = "abc";
		System.out.println("Is String : "+ a + " is a permutation of String: " + b +"? " + Chap1ArraysAndStrings.Q2IsPerumutation(a, b));

		a = "abc";
		b = "abcd";
		System.out.println("Is String : "+ a + " is a permutation of String: " + b +"? " + Chap1ArraysAndStrings.Q2IsPerumutation(a, b));
		
	}
	
	public static void TestURLify(){

		System.out.println("String : null is URLified to : " + Chap1ArraysAndStrings.URLify(null));

		String a= "";
		System.out.println("String : "+ a + " is URLified to : " + Chap1ArraysAndStrings.URLify(a.toCharArray()));
	
		a= "abcde";
		System.out.println("String : "+ a + " is URLified to : " + Chap1ArraysAndStrings.URLify(a.toCharArray()));
		
		a= "abc def  ";
		System.out.println("String : "+ a + " is URLified to : " + Chap1ArraysAndStrings.URLify(a.toCharArray()));
		
		a= " abcdef  ";
		System.out.println("String : "+ a + " is URLified to : " + Chap1ArraysAndStrings.URLify(a.toCharArray()));
		
		a= " abc def    ";
		System.out.println("String : "+ a + " is URLified to : " + Chap1ArraysAndStrings.URLify(a.toCharArray()));
		
	}
	
	public static void TestPalindromePermutation(){

		String a= "";
		System.out.println("String : "+ a + " is Palindrome's perumatation?  : " + Chap1ArraysAndStrings.PalindromePermutation(a));
		
		a= "a";
		System.out.println("String : "+ a + " is Palindrome's perumatation?  : " + Chap1ArraysAndStrings.PalindromePermutation(a));
		
		a= "ab";
		System.out.println("String : "+ a + " is Palindrome's perumatation?  : " + Chap1ArraysAndStrings.PalindromePermutation(a));
		
		a= "aab";
		System.out.println("String : "+ a + " is Palindrome's perumatation?  : " + Chap1ArraysAndStrings.PalindromePermutation(a));
		
		a= "aabb";
		System.out.println("String : "+ a + " is Palindrome's perumatation?  : " + Chap1ArraysAndStrings.PalindromePermutation(a));

		a= "eye";
		System.out.println("String : "+ a + " is Palindrome's perumatation?  : " + Chap1ArraysAndStrings.PalindromePermutation(a));

		a= "Malaylaam";
		System.out.println("String : "+ a + " is Palindrome's perumatation?  : " + Chap1ArraysAndStrings.PalindromePermutation(a));
		
		a= "Malayalama";
		System.out.println("String : "+ a + " is Palindrome's perumatation?  : " + Chap1ArraysAndStrings.PalindromePermutation(a));

		a= "Malayalams";
		System.out.println("String : "+ a + " is Palindrome's perumatation?  : " + Chap1ArraysAndStrings.PalindromePermutation(a));
		
	}
	
	public static void TestOneEditAway(){
		String a= "";
		String b = "";
		System.out.println("String : " + a + " is One edit away from String: " + b + "  ?  : " + Chap1ArraysAndStrings.OneEditAway(a,b));
	
		a= "pale";
		b = "ple";
		System.out.println("String : " + a + " is One edit away from String: " + b + "  ?  : " + Chap1ArraysAndStrings.OneEditAway(a,b));

		a= "pales";
		b = "pale";
		System.out.println("String : " + a + " is One edit away from String: " + b + "  ?  : " + Chap1ArraysAndStrings.OneEditAway(a,b));

		a= "pale";
		b = "bale";
		System.out.println("String : " + a + " is One edit away from String: " + b + "  ?  : " + Chap1ArraysAndStrings.OneEditAway(a,b));

		a= "pale";
		b = "bake";
		System.out.println("String : " + a + " is One edit away from String: " + b + "  ?  : " + Chap1ArraysAndStrings.OneEditAway(a,b));
		
	}

	public static void TestCompress(){
		
		String a = "aab";
		System.out.println("String : "+ a + " After compression is  : " + Chap1ArraysAndStrings.Compress(a));
		
		a = "aaab";
		System.out.println("String : "+ a + " After compression is  : " + Chap1ArraysAndStrings.Compress(a));

		a = "aaaab";
		System.out.println("String : "+ a + " After compression is  : " + Chap1ArraysAndStrings.Compress(a));

		a = "aabcccccaaa";
		System.out.println("String : "+ a + " After compression is  : " + Chap1ArraysAndStrings.Compress(a));
		
	}
	
	public static void TestZeroOutMatrix(){
		
		int[][] matrix = new int[][]{{1,1,0,1},{1,1,1,1},{1,1,1,1},{1,1,1,0}};
		System.out.println("BEFORE zero-ing out");
		printMatrix(matrix);
		System.out.println("AFTER zero-ing out");
		Chap1ArraysAndStrings.ZeroOutMatrix(matrix);
		printMatrix(matrix);
	}
	
	private static void printMatrix(int[][] matrix){
		
		for(int i = 0; i < matrix.length;i++){
			for(int j=0; j< matrix[i].length;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		
	}
	
}