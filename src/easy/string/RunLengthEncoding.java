package easy.string;

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("ccccccccccccbbbbbdefbbbbbbbbbb"));
    }

    //  ccccccccccccbbbbbdefbb
    //  9c3c5bdef2b
    public static String runLengthEncoding(String string) {
        StringBuilder builder = new StringBuilder();
        int beginIndex = 0;
        for (int index = 1; index < string.length(); index++) {
            char lastCharacter = string.charAt(index - 1);
            char currentCharacter = string.charAt(index);
            int repeatLength = index - beginIndex;
            if (currentCharacter == lastCharacter) {
                if (repeatLength == 9) {
                    builder.append(repeatLength);
                    builder.append(string.charAt(index - 1));
                    beginIndex = index;
                }
            } else {
                builder.append(repeatLength);
                builder.append(string.charAt(index - 1));
                beginIndex = index;
            }
        }
        int repeatLength = string.length() - beginIndex;
        builder.append(repeatLength);
        builder.append(string.charAt(string.length() - 1));
        return builder.toString();
    }
}
