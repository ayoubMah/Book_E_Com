import {AppBar, Toolbar, Typography} from "@mui/material";

export default function Header(){
    return(
        <AppBar position = "static" sx = {{mp:4}}>
            <Toolbar>
                <Typography variant="h6">
                    Ayoub Center
                </Typography>
            </Toolbar>
        </AppBar>
    )
}