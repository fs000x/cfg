"判定当前操作系统类型
if(has("win32") || has("win95") || has("win64") || has("win16"))
    let g:iswindows=1
else
    let g:iswindows=0
endif

"设置配色， 在vim中输入:color 按tab可查看
if(g:iswindows==0)
	color peachpuff
else
	color torte
endif
"color default
"color desert
"color ron

"设置背景色，每种配色有两种方案，一个light、一个dark
set background=light

"去掉边框
set go=
"帮助显示中文
set helplang=cn
"打开语法高亮
syntax on
"显示行号
set number
"设置缩进，有三个取值cindent（c风格）、smartindent（智能模式，好像没有那么智能）、autoindent（简单的与上一行保持一致）
set cindent
"在Windows版本中vim的退格键模式默认与vi兼容，修改
set backspace=indent,eol,start
"不要vim模仿vi模式，建议设置，否则会有很多不兼容的问题
set nocompatible
"tab键占4个空格
set tabstop=4
"默认缩进4个空格大小
set shiftwidth=4
"统一缩进为4
set softtabstop=4
"不要用空格代替制表符
set expandtab
"增量式搜索，在输入要搜索的文字时，vim会实时匹配
"set incsearch
"高亮搜索
set hlsearch

"高亮显示匹配的括号
set showmatch
"匹配括号高亮的时间（单位是十分之一秒）
set matchtime=1


"光标移动到buffer的顶部和底部时保持3行距离  
set scrolloff=3
"状态行显示的内容  
set statusline=%F%m%r%h%w\ [FORMAT=%{&ff}]\ [TYPE=%Y]\ [POS=%l,%v][%p%%]\ %{strftime(\"%d/%m/%y\ -\ %H:%M\")}
"启动显示状态行(1),总是显示状态行(2)
set laststatus=2


"很多插件要求的配置检测文件类型
:filetype on
:filetype plugin on
:filetype indent on

"根据不同的文件类型执行不同的命令
"如果是c/c++类型
":autocmd FileType c,cpp :set foldmethod=syntax "自动折叠
:autocmd FileType c,cpp :set number
:autocmd FileType c,cpp :set cindent
"如果是Python类型
":autocmd FileType python :set foldmethod=syntax "自动折叠
:autocmd FileType python :set number
:autocmd FileType python :set smartindent



"自动添加.c文件头
autocmd BufNewFile *.c exec ":call SetComment()"
"加入注释
func SetComment()
    call setline(1, "/**")
    call append(line("."), " * Copyright (C) ".strftime("%Y")." All rights reserved.")
    call append(line(".")+1, " *")
    call append(line(".")+2, " * @file ".expand("%:t"))
    call append(line(".")+3, " * @brief ")
    call append(line(".")+4, " * @date ".strftime("%Y-%m-%d"))
    call append(line(".")+5, " *")
    call append(line(".")+6, " **/")
endfunc

"自动生成.h文件
autocmd BufNewFile *.h exec ":call SetHeader()"
"自动插入.h文件模板
func SetHeader()
    call SetComment()
    call append(line(".")+7, "")
    call append(line(".")+8, "#ifndef _".toupper(expand("%:t:r"))."_H_")
    call append(line(".")+9, "#define _".toupper(expand("%:t:r"))."_H_")
    call append(line(".")+10, "")
    call append(line(".")+11, "")
    call append(line(".")+12, "")
    call append(line(".")+13, "#endif /* _".toupper(expand("%:t:r"))."_H_ */")
endfunc

