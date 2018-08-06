package ThreadProcess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class AsyncTask<Params, Progress, Result> {
	enum Status {FINISHED, PENDING, RUNNING}
	
    private Handler m_handler = new Handler() {
        public void handleMessage(Message msg)
        {
            switch(msg.What) {
            case ON_PROGRESS_UPDATE:
                onProgressUpdate(null);
                break;
                 
            case ON_POST_EXECUTE:
                onPostExecute(null);
                break;
               
            case PUBLISH_PROGRESS:
                publishProgress(null);
                break;
                
            }
        }
    };
    
	public static void execute(Runnable runnable) {
		runnable.run();
	}
    public final AsyncTask<Params, Progress, Result> execute(Params...params) { 
        new Thread(() -> doInBackground(params)).start();
        return this;
    }
    //public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executors exec, Params... params){ return this; }
    public final Result get(long timeout, TimeUnit unit) { return null; }
    public final Result get() { return null; }
    public final AsyncTask.Status getStatus() { return null; }
    public final boolean isCancelled() { return false; }
	
    protected abstract Result doInBackground(Params...params);
    protected void onProgressUpdate(Progress...progresses) {}
    protected void onCancelled() {}
    protected void onCancelled(Result result) {}
    protected void onPostExecute(Result result) {}
    protected void onPreExecute() {}
    protected final void publishProgress(Progress...progresses) {}
    
}
