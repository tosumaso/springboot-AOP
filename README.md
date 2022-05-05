# AOP(Aspect Oriented Programming)

## 用途
* メソッドが本来の処理に集中できるように共通処理を別の空間に分けることができる機能
* 本処理と共通処理を分離することで可読性が増す

##  AOP用語集

|用語|説明|
|----|----|
|Aspect|共通処理を書くクラス|
|Advice|挿入される共通処理|
|JoinPoint|どのタイミングでAdviceを挿入するか。Adviceを注入したターゲットの情報を持つ。|
|Pointcut|どのクラス、メソッドにAdviceを注入するかの条件|

## Aspect
* アスペクトクラスに@Aspectをつける
* Beanとして登録するために@Componentをつける
## Advice
共通処理のメソッド。JoinPoint,Pointcutと組み合わせる。

## JoinPoint

|  JoinPoint  |  Adviceの実行タイミング  |
| ---- | ---- |
|  Before  |  メソッド実行前  |
|  After  |  メソッド実行後  |
| Around | メソッドの前後。Before,Afterの前or後 |
| AfterReturning | メソッドが正常に実行された後 |
| AfterThrowing | メソッドが以上終了した後 |

@JoinPoint(Pointcut)でどのタイミング、ターゲットにAdviceを注入するか決める。

### Before After Aroundの違い
* Before,Afterは引数にJoinPointを、AroundはProceedingJoinPointをとる。
* Aroundはpjp.proceed()でAdviceを挿入したメソッドの戻り値を受け取る。
* proceed()はtry catch構文で囲み、前後に開始ログ、終了ログを書く。

## PointCut

|  PointCut  |  ターゲット  |
| ---- | ---- |
|  execution  | 正規表現を使った条件。クラス、メソッドを対象 |
|  bean  |  DIコンテナに登録されているBeanの全てのメソッドを対象  |
| @annotation | 指定したアノテーションがついているメソッドを対象 |
| @within | 指定したアノテーションがついているクラス内のメソッド全てを対象 |

### PointCutの書き方

@JoinPoint("PointCut(戻り値 パッケージ/クラス.メソッド(引数))")

例: @Before("execution(* demo.example.*Controller.*(..))") : 戻り値がvoid,"demo.example"パッケージで"Controller"で終わる
クラス、任意のメソッドと引数を持つターゲットにAdviceを注入する。
