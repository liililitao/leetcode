/*
 * @lc app=leetcode.cn id=150 lang=c
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start


/*
算法思想：遇到数字则入栈；
遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
*/


bool isNumber(char* token) {//判断是否是数字
    return strlen(token) > 1 || ('0' <= token[0] && token[0] <= '9');
}

int evalRPN(char** tokens, int tokensSize) {
    int n = tokensSize;
    int stk[n], top = 0;//利用数组充当栈，top为栈顶指针
    for (int i = 0; i < n; i++) {
        char* token = tokens[i];
        if (isNumber(token)) {//是数字
            stk[top++] = atoi(token);//入栈
        } else {
            int num2 = stk[--top];//栈顶元素出栈
            int num1 = stk[--top];//栈顶元素出栈
            switch (token[0]) {
                case '+':
                    stk[top++] = num1 + num2;//相加后入栈
                    break;
                case '-':
                    stk[top++] = num1 - num2;//相减后入栈
                    break;
                case '*':
                    stk[top++] = num1 * num2;//相乘后入栈
                    break;
                case '/':
                    stk[top++] = num1 / num2;//相除后入栈
                    break;
            }
        }
    }
    return stk[top - 1];//返回栈顶元素
}

// @lc code=end

