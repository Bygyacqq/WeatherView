import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
public class MySinglenton
{
    private static MySinglenton instance;
    private RequestQueue requestQueue;
    private static Context context;
    private MySinglenton(Context context)
    {
        this.context = context;
        this.requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue() {
        if(requestQueue==null)
        {
            Volley volley = null;
            requestQueue = volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;

    }
    public static synchronized MySinglenton getInstance(Context context)
    {
        if(instance== null)
        {
            instance = new MySinglenton(context);
        }
        return instance;
    }
}
